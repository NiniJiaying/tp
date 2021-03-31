package seedu.booking.logic.commands.states;

import static seedu.booking.commons.core.Messages.PROMPT_EMAIL_PERSON_MESSAGE;
import static seedu.booking.commons.core.Messages.PROMPT_PHONE_MESSAGE;
import static seedu.booking.commons.core.Messages.PROMPT_TAG_MESSAGE;

import java.util.Set;

import seedu.booking.logic.commands.multiprocessing.PersonIntermediate;
import seedu.booking.model.Tag;
import seedu.booking.model.person.Email;
import seedu.booking.model.person.Name;
import seedu.booking.model.person.Person;
import seedu.booking.model.person.Phone;

public class PersonCommandState extends CommandState {
    public static final String STATE_NAME = "NAME";
    public static final String STATE_EMAIL = "PERSON_EMAIL";
    public static final String STATE_PHONE = "PHONE";
    public static final String STATE_TAG = "PERSON_TAG";


    private PersonIntermediate personIntermediate;

    /**
     * Initalises a PersonCommandState
     */
    public PersonCommandState() {
        super();
        this.personIntermediate = new PersonIntermediate();
    }

    @Override
    public void setNextState() {
        String state = this.getState();
        if (state.equals(STATE_NAME)) {
            this.setState(STATE_EMAIL);
            this.setNextPromptMessage(PROMPT_EMAIL_PERSON_MESSAGE);
        } else if (state.equals(STATE_EMAIL)) {
            this.setState(STATE_PHONE);
            this.setNextPromptMessage(PROMPT_PHONE_MESSAGE);
        } else if (state.equals(STATE_PHONE)) {
            this.setState(STATE_TAG);
            this.setNextPromptMessage(PROMPT_TAG_MESSAGE);
        }
    }

    @Override
    public void processInput(Object value) {
        String state = this.getState();
        if (state.equals(STATE_NAME)) {
            personIntermediate.setName((Name) value);
        } else if (state.equals(STATE_PHONE)) {
            personIntermediate.setPhone((Phone) value);
        } else if (state.equals(STATE_EMAIL)) {
            personIntermediate.setEmail((Email) value);
        } else if (state.equals(STATE_TAG)) {
            personIntermediate.setTags((Set<Tag>) value);
        }
    }

    @Override
    public Person create() {
        return personIntermediate.createPerson();
    }
}
