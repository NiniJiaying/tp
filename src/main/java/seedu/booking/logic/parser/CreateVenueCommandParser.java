package seedu.booking.logic.parser;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_CAPACITY;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.stream.Stream;

import seedu.booking.logic.commands.CreateVenueCommand;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.venue.Capacity;
import seedu.booking.model.venue.Venue;
import seedu.booking.model.venue.VenueName;

/**
 * Parses input arguments and creates a new AddVenue object
 */
public class CreateVenueCommandParser implements Parser<CreateVenueCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddVenue
     * and returns an AddVenue object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CreateVenueCommand parse(String args) throws ParseException {
        System.out.println(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_CAPACITY);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_CAPACITY)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateVenueCommand.MESSAGE_USAGE));
        }

        VenueName name = ParserUtil.parseVenueName(argMultimap.getValue(PREFIX_NAME).get());
        Capacity capacity = ParserUtil.parseCapacity(argMultimap.getValue(PREFIX_CAPACITY).get());

        Venue venue = new Venue(name, capacity);

        return new CreateVenueCommand(venue);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
