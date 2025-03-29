package domaine;

import java.util.Date;
import java.util.List;

import static outils.Hash.h;

public class Block {
    private int id;
    private int idPrev;
    private long timestamp;
    private List<Transaction> data;
    private Block prev;

    public Block(List<Transaction> data) {
        this.timestamp = new Date().getTime();
        this.data = data;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdPrev() { return idPrev; }
    public void setIdPrev(int idPrev) { this.idPrev = idPrev; }
    public long getTimestamp() { return timestamp; }
    public List<Transaction> getData() { return data; }
    public Block getPrev() { return prev; }
    public void setPrev(Block prev) { this.prev = prev; }
    public int getHashBlock() { return h(h(getData()) + h(getTimestamp()) + getIdPrev());  }
}