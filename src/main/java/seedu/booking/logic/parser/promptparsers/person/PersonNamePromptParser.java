package seedu.booking.logic.parser.promptparsers.person;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_NAME_FORMAT;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.person.PersonNamePromptCommand;
import seedu.booking.logic.parser.Parser;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.person.Name;

public class PersonNamePromptParser implements Parser<PersonNamePromptCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the name
     * and returns an Name object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PersonNamePromptCommand parse(String args) throws ParseException {
        if (!Name.isValidName(args)) {
            throw new ParseException(MESSAGE_INVALID_NAME_FORMAT + MESSAGE_PROMPT_TRY_AGAIN);
        }

        return new PersonNamePromptCommand(new Name(args));
    }
}
