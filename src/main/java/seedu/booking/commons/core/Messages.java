package seedu.booking.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {
    // Person related messages
    public static final String MESSAGE_DUPLICATE_PERSON_DISPLAYED_EMAIL = "This email address has already been "
            + "registered in the system. Please provide another email address.\n";
    public static final String MESSAGE_DUPLICATE_PERSON_DISPLAYED_PHONE = "This number has been registered in system. "
            + "Please provide another number.\n";
    public static final String PROMPT_PHONE_MESSAGE = "Please enter the phone number of the booker.\n";
    public static final String PROMPT_EMAIL_PERSON_MESSAGE = "Please enter the email address of the booker.\n";
    public static final String MESSAGE_EMAIL_NOT_FOUND =
            "The provided email of the person to be edited does not exist in the system.\n";
    public static final String MESSAGE_INVALID_PERSON_EMAIL = "The email provided does not correspond to any user.";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_EMAIL = "Email address "
            + "provided does not exist in the system.\n";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_NO_PERSONS_FOUND = "No persons found!";
    public static final String MESSAGE_NON_EXISTENT_PERSON_EMAIL =
            "The person email provided does not exist in the system.\n";

    // Venue related messages
    public static final String PROMPT_CAPACITY_MESSAGE = "Please enter the capacity of the venue.\n"
            + "Default capacity is set to 10 if no input is provided.\n";
    public static final String PROMPT_VENUE_DESC_MESSAGE = "Please provide an optional venue description.\n";
    public static final String PROMPT_DUPLICATE_VENUE_MESSAGE = "A venue already exists "
            + "in the system with the same name!\n";
    public static final String MESSAGE_VENUE_LISTED_EMPTY = "There are no venues in the system.\n";
    public static final String MESSAGE_VENUE_NOT_FOUND =
            "The provided venue name of the venue to be edited does not exist in the system.\n";
    public static final String MESSAGE_NON_EXISTENT_VENUE_NAME =
            "The venue name provided does not exist in the system.\n";
    public static final String MESSAGE_VENUE_DISPLAYED = "%1$d Venue(s) displayed!";
    public static final String MESSAGE_NO_VENUES_FOUND = "No venues found!";

    // Booking related messages
    public static final String MESSAGE_BOOKING_DISPLAYED = "%1$d Booking listed!";
    public static final String MESSAGE_INVALID_BOOKING_DISPLAYED_INDEX = "The booking index provided is invalid.";
    public static final String MESSAGE_BOOKING_INDEX_OUT_OF_RANGE = "The booking index provided is out of range.";
    public static final String MESSAGE_NO_BOOKINGS_FOUND = "No bookings found!";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "Invalid date format! Input "
            + "should be in yyyy-mm-dd HH:MM format.\n";
    public static final String MESSAGE_INVALID_TIME =
            "Invalid timing: The booking's starting time cannot be later than its ending time.";
    public static final String MESSAGE_OVERLAPPING_BOOKING = "This time slot has been booked.";

    public static final String MESSAGE_INVALID_EMAIL_FORMAT = "Invalid email address format, please try again.\n";
    public static final String PROMPT_MESSAGE_TRY_AGAIN = "Please try again or enter exit_prompt to quit prompting.\n";
    public static final String PROMPT_MESSAGE_EXIT_PROMPT = "Enter exit_prompt to quit prompting.\n";
    public static final String PROMPT_BOOKING_VENUE_MESSAGE = "Please provide the venue "
            + "name intended for the booking.\n";
    public static final String PROMPT_BOOKING_DESC_MESSAGE = "Please provide an optional booking description.\n";
    public static final String PROMPT_TAG_MESSAGE = "Please add any tags if applicable. "
        + "Multiple tags to be separated with commas.\n";
    public static final String PROMPT_NEWDATE_MESSAGE = "Please try another booking time period.\n";
    public static final String PROMPT_START_MESSAGE = "Please indicate the booking start time. "
            + "Please enter a valid input in yyyy-mm-dd HH:MM format.\n";
    public static final String PROMPT_END_MESSAGE = "Please indicate the booking end time. "
            + "Please enter a valid input in yyyy-mm-dd HH:MM format.\n";
    public static final String INVALID_INDEX = "Invalid index! Please input a positive integer.\n";

    // General messages
    public static final String PROMPT_GENERAL_ERROR = "Error detected. Please exit command and try again.";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command.";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
}
