package main.java.graph;

import java.util.*;

public class BalanceTransactions {

    class Transaction {
        int sender;
        int receiver;
        double amount;

        public Transaction(int sender, int receiver, double amount) {
            this.sender = sender;
            this.receiver = receiver;
            this.amount = amount;
        }

        public void print() {
            System.out.println("transaction: " + this.sender + " sent " + this.receiver + " " + this.amount);
        }
    }

    public List<Transaction> simplifyTransactions(List<Transaction> transactions) {
        Map<Integer, Double> balances = new HashMap<>();

        for (Transaction transaction:transactions) {
            balances.put(transaction.receiver, balances.getOrDefault(transaction.receiver,0D)+transaction.amount);
            balances.put(transaction.sender, balances.getOrDefault(transaction.sender,0D)-transaction.amount);
        }

        Map<Integer, Double> negBalances = new HashMap<>();
        Map<Integer, Double> positiveBalances = new HashMap<>();

        for (Map.Entry<Integer, Double> e: balances.entrySet()) {
            (e.getValue()>0?positiveBalances:negBalances).put(e.getKey(), Math.abs(e.getValue()));
        }

        return constructMinTransactionList(positiveBalances, negBalances);
    }

    private List<Transaction> constructMinTransactionList(Map<Integer, Double> positiveBalances,
                                                          Map<Integer, Double> negBalances) {
        List<Transaction> list = new LinkedList<>();
        if (positiveBalances.isEmpty()) return list;

        removeSameValue(positiveBalances, negBalances, list);

        Iterator<Map.Entry<Integer, Double>> negIt = negBalances.entrySet().iterator();
        Iterator<Map.Entry<Integer, Double>> posIt = positiveBalances.entrySet().iterator();

        Map.Entry<Integer, Double> negEntry = negIt.next();
        Map.Entry<Integer, Double> posEntry = posIt.next();

        while (negIt.hasNext() || posIt.hasNext()) {

            if (!negIt.hasNext()) { // last entry for negative balance
                while (posIt.hasNext()) {
                    list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), posEntry.getValue()));
                    posEntry = posIt.next();
                }
            }
            else if (!posIt.hasNext()) {
                while (negIt.hasNext()) {
                    list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), negEntry.getValue()));
                    negEntry = negIt.next();
                }
            }
            else {
                if (posEntry.getValue() > negEntry.getValue()) {
                    list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), negEntry.getValue()));
                    posEntry.setValue(posEntry.getValue() - negEntry.getValue());
                    negEntry = negIt.next();
                } else if (posEntry.getValue() < negEntry.getValue()) {
                    list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), posEntry.getValue()));
                    negEntry.setValue(negEntry.getValue() - posEntry.getValue());
                    posEntry = posIt.next();
                } else {
                    list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), posEntry.getValue()));
                    posEntry = posIt.next();
                    negEntry = negIt.next();
                }
            }
        }

        list.add(new Transaction(negEntry.getKey(), posEntry.getKey(), posEntry.getValue()));//add the last entry

        return list;
    }

    private void removeSameValue(Map<Integer, Double> positiveMap, Map<Integer, Double> negMap, List<Transaction> list) {
        Set<Map.Entry<Integer, Double>> entries = positiveMap.entrySet();
        Set<Map.Entry<Integer, Double>> negEntries = negMap.entrySet();

        for (Map.Entry<Integer, Double> e:entries) {
            for (Map.Entry<Integer, Double> negE:negEntries) {
                if (e.getValue() == negE.getValue()) {
                    positiveMap.remove(e.getKey());
                    negMap.remove(negE.getKey());
                    list.add(new Transaction(negE.getKey(), e.getKey(), e.getValue()));
                }
            }
        }
    }

    public static void main(String[] args) {
        BalanceTransactions bt = new BalanceTransactions();

        for (Transaction t:bt.simplifyTransactions(new LinkedList<Transaction>(){
            {
                add(bt.new Transaction(1,2,100));
                add(bt.new Transaction(2,3,40));
                add(bt.new Transaction(2,4,30));
                add(bt.new Transaction(4,5,20));
                add(bt.new Transaction(5,1,10));
            }
        }))
            t.print();

        System.out.println();

        for (Transaction t:bt.simplifyTransactions(new LinkedList<Transaction>(){
            {
                add(bt.new Transaction(1,2,40));
                add(bt.new Transaction(2,3,40));
                add(bt.new Transaction(2,4,30));
                add(bt.new Transaction(4,5,20));
                add(bt.new Transaction(5,1,10));
            }
        }))
            t.print();
    }
}
