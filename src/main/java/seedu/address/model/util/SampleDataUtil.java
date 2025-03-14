package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.Goals;
import seedu.address.model.person.Location;
import seedu.address.model.person.Name;
import seedu.address.model.person.OneTimeSchedule;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RecurringSchedule;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"),
                    getRecurringScheduleSet("Mon 1400 1600", "Wed 1600 1800"),
                    new Email("alexyeoh@example.com"), new Goals("Get fitter"),
                    new Location("Blk 30 Geylang Street 29, #06-40"),
                    getOneTimeScheduleSet("25/02 1000 1200", "01/03 1000 1200"), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"),
                    getRecurringScheduleSet("Mon 1400 1600"), new Email("berniceyu@example.com"),
                    new Goals("Lose weight"), new Location("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getOneTimeScheduleSet("25/02 1000 1200"), getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    getRecurringScheduleSet("Mon 1400 1600"), new Email("charlotte@example.com"),
                    new Goals("Gain muscle mass"), new Location("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getOneTimeScheduleSet("25/02 1000 1200"), getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"),
                    getRecurringScheduleSet("Mon 1400 1600"), new Email("lidavid@example.com"),
                    new Goals("Get stronger"), new Location("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getOneTimeScheduleSet("25/02 1000 1200"), getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"),
                    getRecurringScheduleSet("Mon 1400 1600"), new Email("irfan@example.com"),
                    new Goals("Work on stamina"), new Location("Blk 47 Tampines Street 20, #17-35"),
                    getOneTimeScheduleSet("25/02 1000 1200"), getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"),
                    getRecurringScheduleSet("Mon 1400 1600"), new Email("royb@example.com"),
                    new Goals("Calisthenics improvement"), new Location("Blk 45 Aljunied Street 85, #11-31"),
                    getOneTimeScheduleSet("25/02 1000 1200"), getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a recurringSchedule set containing the list of strings given.
     */
    public static Set<RecurringSchedule> getRecurringScheduleSet(String... strings) {
        return Arrays.stream(strings)
                .map(RecurringSchedule::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a one time schedule set containing the list of strings given.
     */
    public static Set<OneTimeSchedule> getOneTimeScheduleSet(String... strings) {
        return Arrays.stream(strings)
                .map(OneTimeSchedule::new)
                .collect(Collectors.toSet());
    }

}
