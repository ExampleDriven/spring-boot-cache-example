package org.exampledriven.springcache.service;

import org.exampledriven.springcache.domain.Account;
import org.exampledriven.springcache.domain.Transfer;
import org.exampledriven.springcache.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "transfer", keyGenerator = "TransferKeyGenerator")
public class BankService {

    @Autowired
    private TransferRepository transferRepository;

    public Transfer createTransfer(Account fromAccount, Account toAccount, int amount) {

        return transferRepository.createTransfer(fromAccount, toAccount, amount);

    }

    @Cacheable(unless = "#result?.status?.name() == 'IN_PROGRESS'")
    public Transfer readTransfer(int id, boolean searchArchives) {
        Transfer transfer = transferRepository.readTransfer(id);

        if (transfer == null && searchArchives) {
            //Search the archives too
        }

        return transfer;
    }

    //keyGenerator could be locally overwritten like this
    //@CachePut(key = "#id")
    @CachePut
    public Transfer completeTransfer(int id, boolean smsAuthenticated, boolean cheapTransfer) {

        //log if smsAuthentication was used
        //charge transfer cheap of expensive transfer price

        return transferRepository.completeTransfer(id);

    }

}
