package seedu.booking.logic.parser;

import static seedu.booking.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.booking.logic.commands.CommandTestUtil.VENUE_NAME_DESC_HALL;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_VENUE;
import static seedu.booking.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.booking.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.booking.logic.commands.FindBookingCommand;
import seedu.booking.model.booking.Booking;
import seedu.booking.model.booking.BookingVenueContainsKeywordsPredicate;

public class FindBookingCommandParserTest {

    private FindBookingCommandParser parser = new FindBookingCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, " ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindBookingCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindBookingCommand() {
        List<Predicate<Booking>> predicateList = new ArrayList<>();
        BookingVenueContainsKeywordsPredicate venueNamePredicate =
                new BookingVenueContainsKeywordsPredicate(Arrays.asList("Victoria", "Hall"));
        predicateList.add(venueNamePredicate);

        FindBookingCommand expectedFindBookingCommand = new FindBookingCommand(predicateList);

        // no leading and trailing whitespaces
        assertParseSuccess(parser, VENUE_NAME_DESC_HALL, expectedFindBookingCommand);

        // multiple whitespaces before and after keywords
        assertParseSuccess(parser, " " + PREFIX_VENUE + "\n Victoria Hall \n ", expectedFindBookingCommand);
    }

}
