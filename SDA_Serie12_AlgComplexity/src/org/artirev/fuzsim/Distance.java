package org.artirev.fuzsim;

import org.artirev.business.Reference;

public class Distance {

    private final Reference referenceA;
    private final Reference referenceB;
    private final Integer distance;

    public Distance(Reference referenceA, Reference referenceB, Integer distance) {
        this.referenceA = referenceA;
        this.referenceB = referenceB;
        this.distance = distance;
    }

    public Reference getReferenceA() {
        return referenceA;
    }

    public Reference getReferenceB() {
        return referenceB;
    }

    public Integer getDistance() {
        return distance;
    }

}
