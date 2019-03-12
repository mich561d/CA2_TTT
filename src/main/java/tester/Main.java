package tester;

import javax.persistence.Persistence;

/**
 *
 * @author Micheal
 */
public class Main {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
    }
}
