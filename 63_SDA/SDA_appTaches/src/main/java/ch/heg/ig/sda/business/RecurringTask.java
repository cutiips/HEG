package ch.heg.ig.sda.business;

/**
 * Classe en phase test représentant une tâche récurrente
 * Cette classe hérite de la classe Task
 */
public class RecurringTask extends Task{
   private final int dayRec;

   /**
    * Constructeur de la classe Task.
    *
    * @param description La description de la tâche
    * @param dayRec le jour de récurrence de la tâche
    */
   public RecurringTask(String description, int dayRec){
       super(description);
       this.dayRec = dayRec;
   }

   /**
    * Obtient le jour de récurrence de la tâche
    *
    * @return Le jour de récurrence de la tâche
    */
   public int getDayRec(){
       return dayRec;
   }

    /**
     * Marque la tâche comme terminée et planifie la prochaine occurrence
     */
    @Override
    public void markAsCompleted() {
        super.markAsCompleted();
    }
}
