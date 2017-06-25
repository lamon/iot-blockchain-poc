import generated.SealMonitor;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.exceptions.TransactionTimeoutException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * Created by lamon
 * sometimes I believe compiler ignores all my comments...
 * based on http://www.javamagazine.mozaicreader.com/JanFeb2017#&pageSet=36&page=0
 */
public class SealMonitorMain {

    public static void main(String[] args) throws IOException, CipherException, ExecutionException, InterruptedException {

        if (args.length < 1) {
            System.out.println("usage: java -jar <wallet-password> <wallet-path>");
            System.out.println("example: java -jar 'yourWalletPassword' '/home/user/wallet/your-wallet.json'");
            return;
        }

        Web3j web3j = Web3j.build(new HttpService());

        // you can use infure as client by the way :)
        // https://infura.io/
        // Web3j web3j = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/<your-infura-token>"));

        Web3ClientVersion clientVersion = web3j.web3ClientVersion().sendAsync().get();
        if (!clientVersion.hasError()) {
            System.out.println(clientVersion.getWeb3ClientVersion());
        }

        Credentials credentials = WalletUtils.loadCredentials(args[0], args[1]);

        //SealMonitor contract = deploySealMonitor(web3j, credentials);

        // https://ropsten.etherscan.io/address/0x88c528f88cf70928e2d969670168a1b33b4734d6
        SealMonitor contract = loadSealMonitor("0x88c528f88cf70928e2d969670168a1b33b4734d6", web3j, credentials);

        TransactionReceipt transactionReceipt = contract.addReport(new Utf8String("Selo VIOLADO!!!!")).get();
        //TransactionReceipt transactionReceipt = contract.addReport(new Utf8String(" Selo intacto.")).get();
        System.out.println(transactionReceipt.getTransactionHash());
        System.out.println(transactionReceipt.getBlockNumber());

    }

    private void transferFundsToAnotherAddress(Web3j web3j, Credentials credentials, String toAddress, double amount)
            throws InterruptedException, ExecutionException, TransactionTimeoutException {
        TransactionReceipt transactionReceipt = Transfer.sendFundsAsync(web3j, credentials, toAddress, BigDecimal.valueOf(amount), Convert.Unit.ETHER).get();
        System.out.println(transactionReceipt.getTransactionHash());
        System.out.println(transactionReceipt.getBlockNumber());
    }

    private static SealMonitor deploySealMonitor(Web3j web3j, Credentials credentials) throws ExecutionException, InterruptedException {
        return SealMonitor.deploy(web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT, BigInteger.ZERO).get();
    }

    private static SealMonitor loadSealMonitor(String contractAddress, Web3j web3j, Credentials credentials) {
        return SealMonitor.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }

}
