package seedu.booking.logic.commands;

import static seedu.booking.commons.core.Messages.PROMPT_NAME_MESSAGE;
import static seedu.booking.logic.commands.states.PersonCommandState.STATE_NAME;

import seedu.booking.logic.commands.states.CommandState;
import seedu.booking.logic.commands.states.PersonCommandState;
import seedu.booking.model.Model;
import seedu.booking.model.ModelManager;

public class PromptCreatePersonCommand extends Command {

    public static final String COMMAND_WORD = "add_person";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Starts the multi-step add person.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {

        CommandState commandState = new PersonCommandState();
        ModelManager.setCommandState(commandState);
        ModelManager.setStateActive();
        ModelManager.setState(STATE_NAME);
        return new CommandResult(PROMPT_NAME_MESSAGE);
    }
}
