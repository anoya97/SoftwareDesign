package e3;


import java.util.ArrayList;


public class Melody {
    private final ArrayList<Enum> notes = new ArrayList<>();
    private final ArrayList<Enum> accidentals = new ArrayList<>();
    private final ArrayList<Float> tiempo = new ArrayList<>();
    private float totalTime = 0;
    private int j = -1;


    enum Accidentals{
        FLAT, SHARP, NATURAL
    }



    public Melody(){

    }

    private boolean comparacion(Notes note1, Notes note2, Accidentals accidental1, Accidentals accidental2){
          if((note1 == Notes.RE && accidental1 == Accidentals.SHARP) && (note2 == Notes.RE && accidental2 == Accidentals.SHARP)){
            return true;
        } else if((note1 == Notes.DO && accidental1 == Accidentals.NATURAL) && (note2 == Notes.DO && accidental2 == Accidentals.NATURAL)){
            return true;
        }  else if((note1 == Notes.MI && accidental1 == Accidentals.NATURAL) && (note2 == Notes.MI && accidental2 == Accidentals.NATURAL)){
            return true;
        } else if((note1 == Notes.MI && accidental1 == Accidentals.FLAT) && (note2 == Notes.MI && accidental2 == Accidentals.FLAT)){
            return true;
        } else if((note1 == Notes.FA && accidental1 == Accidentals.SHARP) && (note2 == Notes.FA && accidental2 == Accidentals.SHARP)){
            return true;
        } else if((note1 == Notes.FA && accidental1 == Accidentals.NATURAL) && (note2 == Notes.FA && accidental2 == Accidentals.NATURAL)){
            return true;
        }  else if((note1 == Notes.SOL && accidental1 == Accidentals.NATURAL) && (note2 == Notes.SOL && accidental2 == Accidentals.NATURAL)){
            return true;
        }  else if((note1 == Notes.LA && accidental1 == Accidentals.FLAT) && (note2 == Notes.LA && accidental2 == Accidentals.FLAT)){
            return true;
        } else if((note1 == Notes.SI && accidental1 == Accidentals.NATURAL) && (note2 == Notes.SI && accidental2 == Accidentals.NATURAL)){
            return true;
        }  else if((note1 == Notes.RE && accidental1 == Accidentals.SHARP) && (note2 == Notes.MI && accidental2 == Accidentals.FLAT)){
            return true;
        } else if((note1 == Notes.MI && accidental1 == Accidentals.NATURAL) && (note2 == Notes.FA && accidental2 == Accidentals.FLAT)){
            return true;
        }  else if((note1 == Notes.FA && accidental1 == Accidentals.SHARP) && (note2 == Notes.SOL && accidental2 == Accidentals.FLAT)){
            return true;
        }  else  if((note1 == Notes.RE && accidental1 == Accidentals.FLAT) && (note2 == Notes.DO && accidental2 == Accidentals.SHARP)){
                return true;
        } else if((note1 == Notes.MI && accidental1 == Accidentals.FLAT) && (note2 == Notes.RE && accidental2 == Accidentals.SHARP)){
                return true;
        } else if((note1 == Notes.MI && accidental1 == Accidentals.SHARP) && (note2 == Notes.FA && accidental2 == Accidentals.NATURAL)){
                return true;
        }else if((note1 == Notes.LA && accidental1 == Accidentals.FLAT) && (note2 == Notes.SOL && accidental2 == Accidentals.SHARP)){
                return true;
        } else if((note1 == Notes.DO && accidental1 == Accidentals.NATURAL) && (note2 == Notes.SI && accidental2 == Accidentals.SHARP)){
                return true;
        } else return (note1 == Notes.DO && accidental1 == Accidentals.FLAT) && (note2 == Notes.SI && accidental2 == Accidentals.NATURAL);

    }

    public void addNote(Notes note, Accidentals accidental, float time){
        if(note != null)
             notes.add(note);
        else
            throw new IllegalArgumentException();
        if (accidental != null)
            accidentals.add(accidental);
        else
            throw new IllegalArgumentException();
        if(time > 0){
            tiempo.add(time);
            totalTime += time;
        } else
            throw new IllegalArgumentException();
        j++;
    }

    public Notes getNote(int index){
        if(index > j){
            throw new IllegalArgumentException();
        } else{
        return (Notes) notes.get(index);
        }
    }

    public Accidentals getAccidental(int index){
        if(index > j){
            throw new IllegalArgumentException();
        }
            return (Accidentals) accidentals.get(index);
    }

    public float getTime(int index){
        if(index > j){
            throw new IllegalArgumentException();
        }
            return tiempo.get(index);
    }



    public int size(){
        return notes.size();
    }
    public float getDuration(){
        return totalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody = (Melody) o;

        if(this.notes.size() != melody.notes.size())
            return false;
        for(int i = 0; i < notes.size(); i++){
            if(this.getTime(i) != melody.getTime(i)){
                return false;
            }
        }
        for(int i = 0; i < notes.size(); i++){
            if(!comparacion(this.getNote(i), melody.getNote(i), this.getAccidental(i), melody.getAccidental(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode () {
        int codigoHash = 0;
        for (int i = 0; i < notes.size() ; i++){
            if(getNote(i) == Notes.DO && getAccidental(i) == Accidentals.SHARP || getNote(i) == Notes.RE && getAccidental(i) == Accidentals.FLAT){
                codigoHash = codigoHash + 31 * Notes.DO.hashCode() + 31 * Accidentals.SHARP.hashCode() + 31 * Float.hashCode(getTime(i));
            }  else  if(getNote(i) == Notes.RE && getAccidental(i) == Accidentals.SHARP || getNote(i) == Notes.MI && getAccidental(i) == Accidentals.FLAT){
                codigoHash = codigoHash + 31 * Notes.RE.hashCode() + 31 * Accidentals.SHARP.hashCode() + 31 * Float.hashCode(getTime(i));
            } else if(getNote(i) == Notes.MI && getAccidental(i) == Accidentals.NATURAL || getNote(i) == Notes.FA && getAccidental(i) == Accidentals.FLAT){
                codigoHash = codigoHash + 31 * Notes.MI.hashCode() + 31 * Accidentals.NATURAL.hashCode() + 31 * Float.hashCode(getTime(i));
            } else if(getNote(i) == Notes.FA && getAccidental(i) == Accidentals.SHARP || getNote(i) == Notes.SOL && getAccidental(i) == Accidentals.FLAT){
                codigoHash = codigoHash + 31 * Notes.FA.hashCode() + 31 * Accidentals.SHARP.hashCode() + 31 * Float.hashCode(getTime(i));
            } else if(getNote(i) == Notes.SOL && getAccidental(i) == Accidentals.NATURAL){
                codigoHash = codigoHash + 31 * Notes.SOL.hashCode() + 31 * Accidentals.NATURAL.hashCode() + 31 * Float.hashCode(getTime(i));
            } else if(getNote(i) == Notes.SOL && getAccidental(i) == Accidentals.SHARP || getNote(i) == Notes.LA && getAccidental(i) == Accidentals.FLAT){
                codigoHash = codigoHash + 31 * Notes.SOL.hashCode() + 31 * Accidentals.SHARP.hashCode() + 31 * Float.hashCode(getTime(i));
            }  else if(getNote(i) == Notes.SI && getAccidental(i) == Accidentals.SHARP || getNote(i) == Notes.DO && getAccidental(i) == Accidentals.NATURAL){
                codigoHash = codigoHash + 31 * Notes.SI.hashCode() + 31 * Accidentals.SHARP.hashCode() + 31 * Float.hashCode(getTime(i));
            } else if(getNote(i) == Notes.SI && getAccidental(i) == Accidentals.NATURAL || getNote(i) == Notes.DO && getAccidental(i) == Accidentals.FLAT) {
                codigoHash = codigoHash + 31 * Notes.SI.hashCode() + 31 * Accidentals.NATURAL.hashCode() + 31 * Float.hashCode(getTime(i));
            }
        }
        return codigoHash;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < notes.size(); i++){
            if(accidentals.get(i) == Accidentals.SHARP){
                sb.append(notes.get(i)).append("#").append("(").append(tiempo.get(i)).append(") ");
            } else if(accidentals.get(i) == Accidentals.FLAT){
                sb.append(notes.get(i)).append("b").append("(").append(tiempo.get(i)).append(") ");
            } else {
            sb.append(notes.get(i)).append("(").append(tiempo.get(i)).append(") ");
            }
        }
        return sb.toString().trim();
    }
}