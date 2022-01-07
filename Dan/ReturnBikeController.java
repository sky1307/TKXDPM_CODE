package controller;

import entity.Bike;
import entity.Station;
import entity.PaymentTransaction;
import entity.Transaction;
import entity.mysqlDao.BikeDao;
import entity.mysqlDao.TransactionDao;
import exception.PaymentException;
import subsystem.banksubsystem.utils.Utils;

import java.sql.Date;
import java.sql.SQLException;

import controller.calculateMoney.Calculator;
import controller.calculateTotalTime.Timer;

/**
 * Class control business of returning bike
 * @author Group 10
 */

public class ReturnBikeController {
    private static PaymentController paymentController;
    private static Timer timer;
    private static Calculator calculator;

    /**
     * Constructor
     */
    public ReturnBikeController() {
    	this.paymentController = new PaymentController();
    	}

    /**
     * refund money after returning bike
     * @param transaction an Singleton transaction
     * @param total total money
     * @param Station {@link entity.Station} user want to return
     * @return 
     * @throws PaymentException PaymentException
     */
    public PaymentTransaction refund(Transaction transaction, Station Station) throws PaymentException {
    	PaymentTransaction paymentTransaction = paymentController.refund(transaction);
    	transaction.setStatus(0);
    	this.makeTransactionDao(transaction, Station);
		return paymentTransaction;
    }

    /**
     * completing some business such as saving to databases, reset {@link Transaction}, ...
     * @param transaction an Singleton transaction
     * @param Station {@link entity.Station} user want to return
     */
    private void makeTransactionDao(Transaction transaction, Station station) {
        TransactionDao transactionDao = new TransactionDao();
        BikeDao bikeDao = new BikeDao();
        transaction.setBikeId(transaction.getBike().getId());
        Bike bike = transaction.getBike();
        bike.setStationId(station.getId());
        transaction.setUserId(0);
        transactionDao.save(transaction);
        bikeDao.update(bike);
    }

	public Transaction getTransaction(int userid) throws SQLException {
		TransactionDao transactionDao = new TransactionDao();
		Transaction rentalTransaction = transactionDao.getByUserID(userid);
		Transaction returnTransaction = new Transaction();
		returnTransaction.setDate(Utils.getToday());
		long totalTime = System.currentTimeMillis() - rentalTransaction.getTotalTime();
		returnTransaction.setTotalTime(totalTime);
		returnTransaction.setTotal(calculator.getTotal( totalTime ));
		return returnTransaction;
	}
	
    public int getTotal(long totalTime) {
        return calculator.getTotal(totalTime);
    }
    
}
