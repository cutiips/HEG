package org.artirev.fuzsim;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.artirev.business.Document;
import org.artirev.business.Documents;
import org.artirev.business.Reference;

import java.util.ArrayList;
import java.util.List;

public class LevDistReferenceSimilarity implements ReferenceSimilarity {

    public List<Distance> computeDistances(Documents documents, int threshold) {

        List<Distance> referenceDistances = new ArrayList<>();

        LevenshteinDistance levenshteinDistance;
        Document documentA;
        Document documentB;
        int distance;

        int countNbRefsCompared = 0;

        for (int i = 0; i < documents.getDocuments().size(); i++) {
            documentA = documents.getDocuments().get(i);
            for (int j = i + 1; j < documents.getDocuments().size(); j++) {
                documentB = documents.getDocuments().get(j);

                // Reference level
                for (Reference referenceA : documentA.getColReferences()) {
                    for (Reference referenceB : documentB.getColReferences()) {
                        countNbRefsCompared += 1;

                        // Calculate distance
                        levenshteinDistance = new LevenshteinDistance();
                        distance = levenshteinDistance.apply(referenceA.getReferenceKey(), referenceB.getReferenceKey());

                        if (distance <= threshold) {
                            referenceDistances.add(new Distance(referenceA, referenceB, distance));
                            System.out.println("SIMILARITY DETECTED (" + referenceDistances.size() + "):");
                            System.out.println("\tDocuments: " + documentA.getTitle() + " - " + documentB.getTitle());
                            System.out.println("\tReferences: " + referenceA.getReferenceKey() + " - " + referenceB.getReferenceKey());
                        }
                    }
                }
            }
        }

        System.out.println("Nb refs comparées: " + countNbRefsCompared);

        return referenceDistances;

    }

}
