package seedu.booking.logic.commands.person;

import static java.util.Objects.requireNonNull;
import static seedu.booking.commons.core.Messages.MESSAGE_DUPLICATE_PERSON_DISPLAYED_PHONE;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.Command;
import seedu.booking.logic.commands.CommandResult;
import seedu.booking.logic.commands.exceptions.CommandException;
import seedu.booking.model.Model;
import seedu.booking.model.ModelManager;
import seedu.booking.model.person.Phone;

public class PersonPhonePromptCommand extends Command {
    private final Phone phone;

    public PersonPhonePromptCommand(Phone phone) {
        this.phone = phone;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPersonWithPhone(phone)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON_DISPLAYED_PHONE
                    + MESSAGE_PROMPT_TRY_AGAIN);
        }

        ModelManager.processStateInput(phone);
        ModelManager.setNextState();
        return new CommandResult(ModelManager.getNextPromptMessage());
    }
}
