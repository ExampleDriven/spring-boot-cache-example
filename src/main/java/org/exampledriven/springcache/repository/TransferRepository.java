package org.exampledriven.springcache.repository;

import org.exampledriven.springcache.domain.Account;
import org.exampledriven.springcache.domain.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TransferRepository {

    private static final Logger logger = LoggerFactory.getLogger(TransferRepository.class);

    private Map<Integer, Transfer> transfers = new HashMap<>();

    public Transfer createTransfer(Account fromAccount, Account toAccount, int amount) {

        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setFromAccount(fromAccount);
        transfer.setToAccount(toAccount);
        transfer.setId(transfers.size());
        transfer.setStatus(Transfer.STATUS.IN_PROGRESS);

        transfers.put(transfer.getId(), transfer);

        logger.debug("Transfer created " + transfer);

        return transfer;
    }

    public Transfer readTransfer(int id) {
        logger.debug("Reading transfer " + id);

        Transfer transfer = transfers.get(id);

        if (transfer != null) {
            logger.debug("Found transfer " + transfer);
        }

        return transfer;
    }

    public Transfer completeTransfer(int id) {
        Transfer transfer = transfers.get(id);
        if (transfer != null) {
            transfer.setStatus(Transfer.STATUS.COMPLETE);
        }
        return transfer;
    }


}
