"""
Bank Management System
A beginner-friendly, menu-driven Python project.
Note: This is an educational simulation, not real banking software.
"""

accounts = {}
next_account_number = 1001


def create_account():
    global next_account_number

    name = input("Enter account holder name: ").strip()
    if not name:
        print("Name cannot be empty.")
        return

    try:
        opening_balance = float(input("Enter opening balance (minimum ₹0): ₹"))
        if opening_balance < 0:
            print("Opening balance cannot be negative.")
            return
    except ValueError:
        print("Please enter a valid amount.")
        return

    account_number = next_account_number
    next_account_number += 1

    accounts[account_number] = {
        "name": name,
        "balance": opening_balance,
        "transactions": [f"Account opened with ₹{opening_balance:.2f}"]
    }

    print("\nAccount created successfully!")
    print(f"Account number: {account_number}")
    print(f"Account holder: {name}")


def find_account():
    try:
        account_number = int(input("Enter account number: "))
    except ValueError:
        print("Please enter a valid account number.")
        return None

    account = accounts.get(account_number)
    if account is None:
        print("Account not found.")
    return account


def check_balance():
    account = find_account()
    if account:
        print(f"Available balance: ₹{account['balance']:.2f}")


def deposit_money():
    account = find_account()
    if not account:
        return

    try:
        amount = float(input("Enter amount to deposit: ₹"))
        if amount <= 0:
            print("Deposit amount must be greater than zero.")
            return
    except ValueError:
        print("Please enter a valid amount.")
        return

    account["balance"] += amount
    account["transactions"].append(f"Deposited ₹{amount:.2f}")
    print(f"Deposit successful. New balance: ₹{account['balance']:.2f}")


def withdraw_money():
    account = find_account()
    if not account:
        return

    try:
        amount = float(input("Enter amount to withdraw: ₹"))
        if amount <= 0:
            print("Withdrawal amount must be greater than zero.")
            return
    except ValueError:
        print("Please enter a valid amount.")
        return

    if amount > account["balance"]:
        print("Insufficient balance.")
        return

    account["balance"] -= amount
    account["transactions"].append(f"Withdrew ₹{amount:.2f}")
    print(f"Withdrawal successful. New balance: ₹{account['balance']:.2f}")


def transaction_history():
    account = find_account()
    if not account:
        return

    print("\n--- Transaction History ---")
    for number, transaction in enumerate(account["transactions"], start=1):
        print(f"{number}. {transaction}")


def display_account_details():
    account = find_account()
    if not account:
        return

    print("\n--- Account Details ---")
    print(f"Account holder: {account['name']}")
    print(f"Balance: ₹{account['balance']:.2f}")


def main():
    while True:
        print("\n========== BANK MANAGEMENT SYSTEM ==========")
        print("1. Create Account")
        print("2. Check Balance")
        print("3. Deposit Money")
        print("4. Withdraw Money")
        print("5. Transaction History")
        print("6. Display Account Details")
        print("7. Exit")

        choice = input("Enter your choice (1-7): ").strip()

        if choice == "1":
            create_account()
        elif choice == "2":
            check_balance()
        elif choice == "3":
            deposit_money()
        elif choice == "4":
            withdraw_money()
        elif choice == "5":
            transaction_history()
        elif choice == "6":
            display_account_details()
        elif choice == "7":
            print("Thank you for using the Bank Management System!")
            break
        else:
            print("Invalid choice. Please select a number from 1 to 7.")


if __name__ == "__main__":
    main()
