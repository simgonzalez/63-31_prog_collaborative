package metier;

import domaine.Block;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private Block head;
    private final List<Block> tousLesBlocks = new ArrayList<>();

    /**
     * Constructeur de la blockchain
     * a) Le block reçu contient déjà le timestamp et les data, prev est à null
     * b) Définir l'id
     * c) Mettre à jour head
     * @param genesis - premier block de la blockchain.
     */
    public Blockchain(Block genesis) {
        genesis.setId(0);
        this.head = genesis;
        this.tousLesBlocks.add(genesis);
    }

    /**
     * Ajouter un block à la blockchain
     * a) Vérifier que l'id reçu est le même que l'id de head
     * b) si pas le même, lancer InvalidIdException
     * c) Définir les attributs manquants dans le block (id, idPrev, prev)
     * d) Mettre à jour head
     * @param id identifiant du block précédent au block à ajouter
     * @param block instance de Block qui doit être ajoutée à la blockchain
     * @return le block modifié
     */
    public Block insert(int id, Block block) {
        if (id != head.getId()) {
            throw new InvalidIdException("Invalid ID: " + id);
        }
        block.setId(head.getId() + 1);
        block.setIdPrev(head.getId());
        block.setPrev(head);
        this.head = block;
        this.tousLesBlocks.add(block);
        return block;
    }

    /**
     * Rechercher un block de la chaîne
     * a) objectif: retourner le block dont l’id est la valeur reçue en paramètre
     * @param id identifiant du block
     * @return le block trouvé
     */
    public Block search(int id) {
        for (Block block : tousLesBlocks) {
            if (block.getId() == id) {
                return block;
            }
        }
        return null;
    }

    /**
     * Retourner un block de la chaîne en ordre constant O(1)
     * a) Objectif: retourner tousLesBlocks.get(i) en ordre O(1)
     * b) Par conséquent, on a besoin d'avoir un accès direct à tousLesBlocks
     * c) déclarer un attribut tousLesBlocks, et le remplir avec chaque block
     * d) et donc ici, dans get ==> Retourner tousLesBlocks.get(i) en ordre O(1)
     * @param id identifiant du block
     * @return le block trouvé
     */
    public Block get(int id) {
        return tousLesBlocks.get(id);
    }

    /**
     * a) Version 1 : Retourner un String contenant l'id de tous les blocks
     * b) Version 2 : Avoir une std permettant de les retourner dans l’ordre (block0, block1, block2, …)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : tousLesBlocks) {
            sb.append(block.getId()).append(" ");
        }
        return sb.toString().trim();
    }
}