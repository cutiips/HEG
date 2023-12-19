package ch.heg.ig.sda.business;

import ch.heg.ig.sda.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestionnaire de tâches permettant d'ajouter, de marquer comme terminées
 * et de supprimer des tâches
 */
public class TaskManager {
    private final List<Task> tasks;

    /**
     * Constructeur de la classe TaskManager
     * Initialise une liste de tâches vide
     *
     *
     */
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * Ajoute une tâche à la liste des tâches
     *
     * @param task La tâche à ajouter
     */
    public void  addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Récupère toutes les tâches dans la liste
     *
     * @return La liste de toutes les tâches
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Marque une tâche spécifique comme terminée
     *
     * @param task La tâche à marquer comme terminée
     */
    public void markTaskAsCompleted(Task task) throws ServiceException {
        for (Task t : tasks) {
            if (t.equals(task)) {
                t.markAsCompleted();
                return;
            }
        }
        throw new ServiceException("La tâche n'existe pas.");
    }

    /**
     * Supprime toutes les tâches marquées comme terminées de la liste
     */
    public void removeCompletedTasks() {
        tasks.removeIf(Task::isCompleted);
    }
}
