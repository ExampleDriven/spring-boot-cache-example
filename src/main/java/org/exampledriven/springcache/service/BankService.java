package org.exampledriven.springcache.service;

import org.exampledriven.springcache.domain.Account;
import org.exampledriven.springcache.domain.Transfer;
import org.exampledriven.springcache.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private TransferRepository transferRepository;

    public Transfer createTransfer(Account fromAccount, Account toAccount, int amount) {

        return transferRepository.createTransfer(fromAccount, toAccount, amount);

    }

    @Cacheable(value = "transfer", unless = "#result?.status?.name() == 'IN_PROGRESS'")
    public Transfer readTransfer(int id) {
        return transferRepository.readTransfer(id);
    }

    public Transfer completeTransfer(Transfer transfer) {
        transfer.setStatus(Transfer.STATUS.COMPLETE);
        return transfer;
    }

}
