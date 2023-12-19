package ch.heg.ig.sda.business;

import java.time.LocalDate;

/**
 * Classe en phase test représentant une tâche récurrente
 * Cette classe hérite de la classe Task
 */
public class RecurringTask extends Task{
   private final int dayRec;

   /**
    * Constructeur de la classe Task.
    *
    * @param descrption La description de la tâche
    * @param dayRec le jour de récurrence de la tâche
    */
   public RecurringTask(String descrption, int dayRec){
       super(descrption);
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

        LocalDate dateDebut = LocalDate.now();

        LocalDate nextRecurrence = dateDebut.plusDays(dayRec);
    }
}
