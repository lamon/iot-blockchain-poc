package generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.2.1.
 */
public final class SealMonitor extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b61057d8061001c6000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166357ca4fe6811461005b578063a3c86daf146100c5578063c942adf714610130578063cfb51928146101cd575bfe5b341561006357fe5b6100b1600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965061023595505050505050565b604080519115158252519081900360200190f35b34156100cd57fe5b6100d5610288565b604080516020808252835181830152835191928392908301918581019102808383821561011d575b80518252602083111561011d57601f1990920191602091820191016100fd565b5050509050019250505060405180910390f35b341561013857fe5b6101436004356103ab565b6040805160208082528354600260001961010060018416150201909116049082018190529091829190820190849080156101be5780601f10610193576101008083540402835291602001916101be565b820191906000526020600020905b8154815290600101906020018083116101a157829003601f168201915b50509250505060405180910390f35b34156101d557fe5b610223600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496506103cd95505050505050565b60408051918252519081900360200190f35b600061023f6103d8565b828152600080546001810161025483826103f1565b916000526020600020900160005b50825180518492916102799183916020019061041b565b50505050600191505b50919050565b61029061049a565b600061029a61049a565b6000805460405190935083908059106102b05750595b908082528060200260200182016040525b509150600090505b828110156103a1576103806000828154811015156102e357fe5b906000526020600020900160005b50805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156103765780601f1061034b57610100808354040283529160200191610376565b820191906000526020600020905b81548152906001019060200180831161035957829003601f168201915b50505050506103cd565b828281518110151561038e57fe5b602090810290910101525b6001016102c9565b8193505b50505090565b60008054829081106103b957fe5b906000526020600020900160005b50905081565b60208101515b919050565b6020604051908101604052806103ec61049a565b905290565b815481835581811511610415576000838152602090206104159181019083016104be565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061045c57805160ff1916838001178555610489565b82800160010185558215610489579182015b8281111561048957825182559160200191906001019061046e565b5b506104969291506104e8565b5090565b60408051602081019091526000815290565b60408051602081019091526000815290565b6104e591905b808211156104965760006104d88282610509565b506001016104c4565b5090565b90565b6104e591905b8082111561049657600081556001016104ee565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061052f575061054d565b601f01602090049060005260206000209081019061054d91906104e8565b5b505600a165627a7a7230582090b2f892b545632e444bf658d63ac403f80633d98f6edf0af970419e72621fb00029";

    private SealMonitor(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SealMonitor(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> addReport(Utf8String _status) {
        Function function = new Function("addReport", Arrays.<Type>asList(_status), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<DynamicArray<Bytes32>> getReports() {
        Function function = new Function("getReports", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> reports(Uint256 param0) {
        Function function = new Function("reports", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> stringToBytes32(Utf8String source) {
        Function function = new Function("stringToBytes32", Arrays.<Type>asList(source), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<SealMonitor> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(SealMonitor.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<SealMonitor> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(SealMonitor.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static SealMonitor load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SealMonitor(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SealMonitor load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SealMonitor(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
