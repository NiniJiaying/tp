package seedu.booking.logic.commands;

import static seedu.booking.logic.commands.CommandShowType.COMMAND_SHOW_NONE;

import seedu.booking.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Booking App as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, COMMAND_SHOW_NONE, true);
    }

}
