package lean.java.example.Immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ImmutableTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list：" + list);

        ImmutableList<String> imList = ImmutableList.copyOf(list);
        System.out.println("imList：" + imList);

        ImmutableList<String> imOfList = ImmutableList.of("peida", "jerry", "harry");
        System.out.println("imOfList：" + imOfList);

        ImmutableSortedSet<String> ofList = ImmutableSortedSet.of("a", "c", "r", "1", "f", "a");
        System.out.println("ofList：" + ofList);
    }
}
