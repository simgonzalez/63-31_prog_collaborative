import domaine.Block;
import metier.Blockchain;
import outils.BlockGenerator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Block> blocks = BlockGenerator.generateBlocks();

        // a) Créer une blockchain (avec le bloc 0)
        Blockchain blockchain = new Blockchain(blocks.get(0));

        // b) Insérer tous les blocks (1 à n-1) dans la blockchain
        for (int i = 1; i < blocks.size(); i++) {
            blockchain.insert(i - 1, blocks.get(i));
        }

        // c) Afficher la blockchain
        System.out.println(blockchain);

        // d) Rechercher un bloc en utilisant search et get
        Block searchedBlock = blockchain.search(2);
        System.out.println("Searched Block: " + (searchedBlock != null ? searchedBlock.getId() : "Not Found"));

        Block getBlock = blockchain.get(2);
        System.out.println("Get Block: " + (getBlock != null ? getBlock.getId() : "Not Found"));
    }
}
