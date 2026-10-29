package spettacolo;

public class Spettacolo {
    int capienza = 30;
    int disponibilita = 30;

    public int disponibile(){
        return disponibilita;
    }

    public int prenotazione(int posti){
        if(posti > disponibilita){
            return -1;
        }
        else{
            disponibilita -=  posti;
            return disponibilita;
        }
    }

    public int annulla(int posti){
        if((disponibilita+posti) > 30){
            return -1;
        }
        else{
            disponibilita += posti;
            return disponibilita;
        }
    }
}
