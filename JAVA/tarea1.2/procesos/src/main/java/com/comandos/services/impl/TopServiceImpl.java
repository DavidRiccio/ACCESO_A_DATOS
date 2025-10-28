package com.comandos.services.impl;

import com.comandos.domain.Job;
import com.comandos.services.abstracts.ComandoServiceAbstract;

public class TopServiceImpl extends ComandoServiceAbstract{
    public TopServiceImpl(){
        this.setTipo(Job.TOP);
    }
}
