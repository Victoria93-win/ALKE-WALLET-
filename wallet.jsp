<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Alke Wallet</h2>

<p>Saldo: ${balance} ${currency}</p>

<form method="post" action="wallet">
    <input type="number" name="amount" placeholder="Monto">
    <button name="action" value="deposit">Depositar</button>
    <button name="action" value="withdraw">Retirar</button>
</form>

<form method="post" action="wallet">
    <select name="currency">
        <option value="USD">USD</option>
        <option value="EUR">EUR</option>
    </select>
    <button name="action" value="convert">Convertir</button>
</form>

<p style="color:red;">${error}</p>