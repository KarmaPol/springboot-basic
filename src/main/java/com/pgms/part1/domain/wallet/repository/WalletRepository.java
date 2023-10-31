package com.pgms.part1.domain.wallet.repository;

import com.pgms.part1.domain.customer.entity.Customer;
import com.pgms.part1.domain.voucher.dto.VoucherWalletResponseDtos;
import com.pgms.part1.domain.wallet.entity.Wallet;

import java.util.List;

public interface WalletRepository {

    public List<VoucherWalletResponseDtos> findVouchersByCustomerId(Long id);
    public List<Customer> findCustomersByVoucherId(Long id);
    public void addWallet(Wallet wallet);
    public void deleteWallet(Long id);

}
