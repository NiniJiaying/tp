package seedu.booking.logic.parser.promptparsers.booking;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_EMAIL_FORMAT;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.booking.BookingEmailPromptCommand;
import seedu.booking.logic.parser.Parser;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.person.Email;

public class EmailPromptParser implements Parser<BookingEmailPromptCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the email
     * and returns an Email object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public BookingEmailPromptCommand parse(String args) throws ParseException {
        if (!Email.isValidEmail(args)) {
            throw new ParseException(MESSAGE_INVALID_EMAIL_FORMAT + MESSAGE_PROMPT_TRY_AGAIN);
        }

        return new BookingEmailPromptCommand(new Email(args));
    }
}
