package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenAscByNameComparator() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("wash the car", 1),
                new Job("refuel the car", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescByNameComparator() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("buy an asset", 1),
                new Job("business lunch", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriorityComparator() {
        Comparator<Job> cmpPrior = new JobAscByPriority();
        int rsl = cmpPrior.compare(
                new Job("wash the car", 1),
                new Job("refuel the car", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescByPriorityComparator() {
        Comparator<Job> cmpPrior = new JobDescByPriority();
        int rsl = cmpPrior.compare(
                new Job("send an email", 1),
                new Job("answer the phone call", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndAscByPriorityComparator() {
        Comparator<Job> cmpAscNameAscPriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpAscNameAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriorityAndDescByNameComparator() {
        Comparator<Job> cmpAscPriorityDescName = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpAscPriorityDescName.compare(
                new Job("Turn on the light", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}
