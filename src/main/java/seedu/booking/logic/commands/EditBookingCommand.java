package seedu.booking.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_BOOKER;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_BOOKING_END;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_BOOKING_START;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_VENUE;
import static seedu.booking.model.Model.PREDICATE_SHOW_ALL_BOOKINGS;

import java.util.List;
import java.util.Optional;

import seedu.booking.commons.core.Messages;
import seedu.booking.commons.util.CollectionUtil;
import seedu.booking.logic.commands.exceptions.CommandException;
import seedu.booking.model.Model;
import seedu.booking.model.booking.Booking;
import seedu.booking.model.booking.Description;
import seedu.booking.model.booking.EndTime;
import seedu.booking.model.booking.Id;
import seedu.booking.model.booking.StartTime;
import seedu.booking.model.person.Person;
import seedu.booking.model.venue.Venue;

public class EditBookingCommand extends Command {
    public static final String COMMAND_WORD = "edit_booking";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the booking identified "
            + "by the id used in the displayed booking list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: bid/BOOKING_ID "
            + "[" + PREFIX_BOOKER + "BOOKER] "
            + "[" + PREFIX_VENUE + "VENUE] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION] "
            + "[" + PREFIX_BOOKING_START + "DATETIME] "
            + "[" + PREFIX_BOOKING_END + "DATETIME] "
            + "Example: " + COMMAND_WORD + " bid/1234567890 "
            + PREFIX_BOOKER + "John Doe "
            + PREFIX_VENUE + "Hall "
            + PREFIX_DESCRIPTION + "For FYP meeting. "
            + PREFIX_BOOKING_START + "2012-01-31 22:59:59 "
            + PREFIX_BOOKING_END + "2012-01-31 23:59:59";

    public static final String MESSAGE_EDIT_BOOKING_SUCCESS = "Edited Booking: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_BOOKING = "This booking already exists in the booking system.";

    private final Id id;
    private final EditBookingDescriptor editBookingDescriptor;

    /**
     * @param id of the booking in the filtered booking list to edit.
     * @param editBookingDescriptor details to edit the booking with.
     */
    public EditBookingCommand(Id id, EditBookingDescriptor editBookingDescriptor) {
        requireNonNull(id);
        requireNonNull(editBookingDescriptor);

        this.id = id;
        this.editBookingDescriptor = new EditBookingDescriptor(editBookingDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Booking> lastShownList = model.getFilteredBookingList();

        if (lastShownList.stream().noneMatch(booking -> booking.getId().equals(id))) {
            throw new CommandException(Messages.MESSAGE_INVALID_BOOKING_ID);
        }

        Booking bookingToEdit = getBookingById(id, lastShownList);
        Booking editedBooking = createEditedBooking(bookingToEdit, editBookingDescriptor);

        if (!bookingToEdit.isSameBooking(editedBooking) && model.hasBooking(editedBooking)) {
            throw new CommandException(MESSAGE_DUPLICATE_BOOKING);
        }

        model.setBooking(bookingToEdit, editedBooking);
        model.updateFilteredBookingList(PREDICATE_SHOW_ALL_BOOKINGS);
        return new CommandResult(String.format(MESSAGE_EDIT_BOOKING_SUCCESS, editedBooking));
    }

    private static Booking getBookingById(Id id, List<Booking> bookingList) {
        return bookingList.stream()
                .filter(booking -> booking.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Creates and returns a {@code Booking} with the details of {@code bookingToEdit}
     * edited with {@code editBookingDescriptor}.
     */
    private static Booking createEditedBooking(Booking bookingToEdit, EditBookingDescriptor editBookingDescriptor) {
        assert bookingToEdit != null;

        Person updatedBooker = editBookingDescriptor.getBooker().orElse(bookingToEdit.getBooker());
        Venue updatedVenue = editBookingDescriptor.getVenue().orElse(bookingToEdit.getVenue());
        Description updatedDescription = editBookingDescriptor.getDescription().orElse(bookingToEdit.getDescription());
        StartTime updatedBookingStart = editBookingDescriptor.getBookingStart().orElse(bookingToEdit.getBookingStart());
        EndTime updatedBookingEnd = editBookingDescriptor.getBookingEnd().orElse(bookingToEdit.getBookingEnd());
        //Id updatedId = editBookingDescriptor.getId().orElse(bookingToEdit.getId());
        return new Booking(updatedBooker, updatedVenue, updatedDescription, updatedBookingStart, updatedBookingEnd);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditBookingCommand)) {
            return false;
        }

        // state check
        EditBookingCommand e = (EditBookingCommand) other;
        return id.equals(e.id)
                && editBookingDescriptor.equals(e.editBookingDescriptor);
    }

    /**
     * Stores the details to edit the booking with. Each non-empty field value will replace the
     * corresponding field value of the booking.
     */
    public static class EditBookingDescriptor {
        private Person booker;
        private Venue venue;
        private Description description;
        private StartTime bookingStart;
        private EndTime bookingEnd;
        private Id id;

        public EditBookingDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditBookingDescriptor(EditBookingDescriptor toCopy) {
            setBooker(toCopy.booker);
            setVenue(toCopy.venue);
            setDescription(toCopy.description);
            setBookingStart(toCopy.bookingStart);
            setBookingEnd(toCopy.bookingEnd);
            setId(toCopy.id);
        }

        private void setId(Id id) {
            this.id = id;
        }

        public Optional<Id> getId() {
            return Optional.ofNullable(id);
        }

        private void setBookingEnd(EndTime bookingEnd) {
            this.bookingEnd = bookingEnd;
        }

        public Optional<EndTime> getBookingEnd() {
            return Optional.ofNullable(bookingEnd);
        }

        private void setBookingStart(StartTime bookingStart) {
            this.bookingStart = bookingStart;
        }

        public Optional<StartTime> getBookingStart() {
            return Optional.ofNullable(bookingStart);
        }

        private void setDescription(Description description) {
            this.description = description;
        }

        public Optional<Description> getDescription() {
            return Optional.ofNullable(description);
        }

        private void setVenue(Venue venue) {
            this.venue = venue;
        }

        public Optional<Venue> getVenue() {
            return Optional.ofNullable(venue);
        }

        public void setBooker(Person booker) {
            this.booker = booker;
        }

        public Optional<Person> getBooker() {
            return Optional.ofNullable(booker);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(booker, venue, description, bookingStart, bookingEnd, id);
        }


        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditBookingDescriptor)) {
                return false;
            }

            // state check
            EditBookingDescriptor e = (EditBookingDescriptor) other;

            return getBooker().equals(e.getBooker())
                    && getVenue().equals(e.getVenue())
                    && getDescription().equals(e.getDescription())
                    && getBookingStart().equals(e.getBookingStart())
                    && getBookingEnd().equals(e.getBookingEnd())
                    && getId().equals(e.getId());
        }
    }
}