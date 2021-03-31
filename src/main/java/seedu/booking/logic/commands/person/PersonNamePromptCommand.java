package seedu.booking.logic.commands.person;

import static java.util.Objects.requireNonNull;

import seedu.booking.logic.commands.Command;
import seedu.booking.logic.commands.CommandResult;
import seedu.booking.logic.commands.exceptions.CommandException;
import seedu.booking.model.Model;
import seedu.booking.model.ModelManager;
import seedu.booking.model.person.Name;

public class PersonNamePromptCommand extends Command {
    private final Name name;

    public PersonNamePromptCommand(Name name) {
        this.name = name;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ModelManager.processStateInput(name);
        ModelManager.setNextState();
        return new CommandResult(ModelManager.getNextPromptMessage());
    }
}
