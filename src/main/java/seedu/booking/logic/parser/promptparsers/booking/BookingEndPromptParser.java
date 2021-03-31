package seedu.booking.logic.parser.promptparsers.booking;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_DATE_FORMAT;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.booking.BookingEndPromptCommand;
import seedu.booking.logic.parser.Parser;
import seedu.booking.logic.parser.ParserUtil;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.booking.EndTime;

public class BookingEndPromptParser implements Parser<BookingEndPromptCommand> {

    /**
     * Adds a booking venue to the system.
     */
    public BookingEndPromptCommand parse(String args) throws ParseException {
        EndTime endTime;

        try {
            endTime = ParserUtil.parseBookingEnd(args);
        } catch (Exception ex) {
            throw new ParseException(MESSAGE_INVALID_DATE_FORMAT + MESSAGE_PROMPT_TRY_AGAIN);
        }

        return new BookingEndPromptCommand(endTime);
    }
}
