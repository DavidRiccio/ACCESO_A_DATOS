package com.comandos.services.impl;

import com.comandos.domain.Job;
import com.comandos.services.abstracts.ComandoServiceAbstract;

public class PsHeadServiceImpl extends ComandoServiceAbstract {
    public PsHeadServiceImpl(){
        this.setTipo(Job.PSHEAD);
    }
    
}
