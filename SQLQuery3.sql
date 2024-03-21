/* Select Animale + Specie */
SELECT A.Data_nastere, A.Pret, A.Sex, S.Denumire_latina, S.Familie
FROM Animal A FULL JOIN Specie S
ON A.Specie_ID = S.Specie_ID;

/* Select Magazine */
SELECT Judet, Oras, Strada, Numar, Data_deschidere, Chirie_luna
FROM Magazin;

/* Select Facturi */
SELECT
    F.Data_emitere,
    F.Suma_Totala,
    COALESCE(SUM(H.Cantitate), 0) AS Sum_Hrana,
    COALESCE(SUM(A.Cantitate), 0) AS Sum_Animal
FROM
    Factura F
    FULL JOIN Bon_Hrana H ON F.Factura_ID = H.Factura_ID
    FULL JOIN Bon_Animal A ON F.Factura_ID = A.Factura_ID
GROUP BY
    F.Data_emitere,
    F.Suma_Totala;

/* Select Hrana */
SELECT Data_expirare, Pret, Gramaj, Cod_bare
FROM Hrana;

/* Select Specii care nu sunt in depozit */

SELECT S.Denumire_latina, S.Familie
FROM Specie S
JOIN Animal A ON S.Specie_ID = A.Specie_ID
WHERE A.Animal_ID NOT IN (
    SELECT DISTINCT A2.Animal_ID
    FROM Animal A2
    JOIN Hrana_Animal HA ON A2.Animal_ID = HA.Animal_ID
);

/* Select Factura maxima per oras magazin */

SELECT M.Oras, F.Suma_Totala
FROM Factura F
JOIN Magazin M ON M.Magazin_ID = F.Magazin_ID
WHERE F.Suma_Totala = (
    SELECT MAX(Suma_Totala)
    FROM Factura, Magazin M2
    WHERE M2.Magazin_ID = F.Magazin_ID
);

/* Nr facturi per oras */

SELECT
    M.Magazin_ID,
    M.Oras,
    COUNT(F.Factura_ID) AS NumberOfBills
FROM
    Magazin M
LEFT JOIN
    Factura F ON M.Magazin_ID = F.Magazin_ID
GROUP BY
    M.Magazin_ID, M.Oras;

/* Cel mai profitabil */

SELECT
    Oras,
    Profit - Chirie AS ProfitBrut
FROM
    (
        SELECT TOP 1
            M.Oras,
            COALESCE(SUM(F.Suma_Totala), 0) AS Profit,
            COALESCE(SUM(M.Chirie_luna), 0) AS Chirie
        FROM
            Magazin M
        LEFT JOIN
            Factura F ON M.Magazin_ID = F.Magazin_ID
        GROUP BY
            M.Oras
    ) AS ShopProfit
ORDER BY
    ProfitBrut DESC;

	/* Cel mai profitabil dupa TVA pe vanzari*/

SELECT
    Oras,
    Profit * 76 / 100 - Chirie AS ProfitNet
FROM
    (
        SELECT TOP 1
            M.Oras,
            COALESCE(SUM(F.Suma_Totala), 0) AS Profit,
            COALESCE(SUM(M.Chirie_luna), 0) AS Chirie
        FROM
            Magazin M
        LEFT JOIN
            Factura F ON M.Magazin_ID = F.Magazin_ID
        GROUP BY
            M.Oras
    ) AS ShopProfit
ORDER BY
    ProfitNet DESC;

	/* SELECT ANIMALE CARE AU SI MANCARE */
	SELECT
    H.Cod_bare,
    A.Animal_ID
FROM
    Hrana_Animal HA
LEFT JOIN
    Hrana H ON HA.Hrana_ID = H.Hrana_ID
LEFT JOIN
    Animal A ON A.Animal_ID = HA.Animal_ID
WHERE HA.Disponabilitate_depozit = 'Da';
