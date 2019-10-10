package com.epam.training.sportsbetting.domain;

import java.util.List;

public class Result {

    private List<OutCome> outComes;

    public Result(List<OutCome> outComes)
    {
        this.setOutComes(outComes);
    }

    public List<OutCome> getOutComes() {
        return outComes;
    }

    public void setOutComes(List<OutCome> outComes) {
        this.outComes = outComes;
    }
}
