package seedu.booking.logic.commands.person;

import static java.util.Objects.requireNonNull;
import static seedu.booking.commons.core.Messages.MESSAGE_DUPLICATE_PERSON_DISPLAYED_EMAIL;
import static seedu.booking.commons.core.Messages.MESSAGE_PROMPT_TRY_AGAIN;

import seedu.booking.logic.commands.Command;
import seedu.booking.logic.commands.CommandResult;
import seedu.booking.logic.commands.exceptions.CommandException;
import seedu.booking.model.Model;
import seedu.booking.model.ModelManager;
import seedu.booking.model.person.Email;

public class PersonEmailPromptCommand extends Command {
    private final Email email;

    public PersonEmailPromptCommand(Email email) {
        this.email = email;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPersonWithEmail(email)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON_DISPLAYED_EMAIL
                    + MESSAGE_PROMPT_TRY_AGAIN);
        }

        ModelManager.processStateInput(email);
        ModelManager.setNextState();
        return new CommandResult(ModelManager.getNextPromptMessage());
    }
}
