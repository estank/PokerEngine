public class Table {
    private int seats;
    private int players;


    public Table(){
        seats = 9;
        players = 0;
    }

    public Table(int seats, int players){
        this.seats = seats;
        this.players = players;
    }
    public void setSeats(int seats){
        this.seats = seats;
    }
    public void setPlayers(int players){
        this.players = players;
    }
    public int getSeats(){ return seats; }
    public int getPlayers(){ return players; }

}
