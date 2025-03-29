package outils;

import domaine.Block;
import domaine.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BlockGenerator {
    public static List<Block> generateBlocks() {
        List<Block> blocks = new ArrayList();

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(generateTransaction("Christian", 50, "Douglas"));
        transactions.add(generateTransaction("Alexie", 0.5f, "Flávio"));
        transactions.add(generateTransaction("Alexie", 12, "Steeve"));
        transactions.add(generateTransaction("Loïc", 0.33f, "Lucas"));
        blocks.add(new Block(transactions));

        transactions = new ArrayList<>();
        transactions.add(generateTransaction("Douglas", 150, "Nader"));
        transactions.add(generateTransaction("Nader", 25, "Trabix"));
        transactions.add(generateTransaction("Nadir", 12, "Baptiste"));
        blocks.add(new Block(transactions));

        transactions  = new ArrayList<>();
        transactions.add(generateTransaction("Sara", 0.6f, "Flávio"));
        blocks.add(new Block(transactions));

        transactions  = new ArrayList<>();
        transactions.add(generateTransaction("Jerome", 1, "Douglas"));
        transactions.add(generateTransaction("Djavan", 0.5f, "Alexie"));
        transactions.add(generateTransaction("Alexie", 200, "Flávio"));
        transactions.add(generateTransaction("Lucas", 6.7f, "David"));
        blocks.add(new Block(transactions));

        return blocks;
    }

    public static Transaction generateTransaction(String source, float value, String destination) {
        return new Transaction(source + " a envoyé " + value + "BT à " + destination);
    }
}