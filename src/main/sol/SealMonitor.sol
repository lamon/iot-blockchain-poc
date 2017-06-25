pragma solidity ^0.4.2;

contract SealMonitor {

    Report[] public reports;

    struct Report {
        string status;
    }

    function addReport(string _status) returns (bool success) {
        Report memory report;
        report.status = _status;
    
        reports.push(report);
        return true;
    }

}