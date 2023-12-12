package org.artirev.fuzsim;

import org.artirev.business.Documents;

import java.util.List;

public interface ReferenceSimilarity {

    List<Distance> computeDistances(Documents documents, int threshold);

}
