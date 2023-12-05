import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {

    public static final List<String> list =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 3 - 4");
                        add("M - 3 - 4");
                        add("T - 3 - 4");
                        add("C - 3 - 5");
                    }});

    public static final List<String> list2 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 3 - 4");
                        add("M - 3 - 4");
                        add("T - 3 - 4 - 5");
                        add("C - 3 - 5");
                    }});

    public static final List<String> list3 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 3 - 4");
                        add("T - 3 - 4 - 5");
                        add("A - Jon Jones - 3 - 5 - S - AA");
                        add("A - Jonah Hill - 3 - 6 - N - AAADDDGGADGDGGDAADDGG");
                    }});

    public static final List<String> list4 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 10 - 20");
                        add("M - 3 - 4");
                        add("T - 4 - 4 - 10");
                        add("C - 7 - 7");
                        add("A - Jon JonesA - 3 - 5 - S - AAADDDGGADGDGGDAADDGG");
                        add("A - Jonah Hill - 3 - 5 - N - AAADDDGGADGDGGDAADDGG");
                    }});

    public static final List<String> list5 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 10 - 20");
                        add("M - 3 - 4");
                        add("T - 4 - 4 - 10");
                        add("C - 10 - 20");
                        add("A - Jon Jones - 3 - 5 - S - AA");
                        add("A - Jonah Hill - 3 - 4 - N - AAG");
                    }});

    public static final List<String> list6 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 10 - 20");
                        add("M - 3 - 4");
                        add("T - 4 - 4 - 10");
                        add("C - 10 - 20");
                        add("A - Jon Jones - 3 - 5 - S - AAAAAAAAAAAAAAAAAAAAAAAAA");
                        add("A - Jonah Hill - 5 - 9 - N - AAGAA");
                    }});

    public static final List<String> list7 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 5 - 5");
                        add("M - 0 - 1");
                        add("A - Jon Jones - 0 - 0 - S - AA");
                    }});

    public static final List<String> list8 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 5 - 5");
                        add("T - 0 - 1 - 5");
                        add("A - Jon Jones - 0 - 0 - S - AA");
                    }});

    public static final List<String> list9 =
            Collections.unmodifiableList(
                    new ArrayList<String>() {{
                        add("C - 10 - 20");
                        add("M - 3 - 4");
                        add("T - 4 - 4 - 10");
                        add("A - Jon Jones - 4 - 5 - N - AAAAAAAAAAAAAAAAAAAAAAAAA");
                        add("A - Jonah Hill - 5 - 9 - N - AAGAA");
                    }});
}
