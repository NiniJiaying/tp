package seedu.booking.logic.parser.promptparsers.person;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_PHONE_FORMAT;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.person.PersonPhonePromptCommand;
import seedu.booking.logic.parser.Parser;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.person.Phone;

public class PersonPhonePromptParser implements Parser<PersonPhonePromptCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the phone
     * and returns an Phone object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PersonPhonePromptCommand parse(String args) throws ParseException {
        if (!Phone.isValidPhone(args)) {
            throw new ParseException(MESSAGE_INVALID_PHONE_FORMAT + MESSAGE_PROMPT_TRY_AGAIN);
        }

        return new PersonPhonePromptCommand(new Phone(args));
    }
}
