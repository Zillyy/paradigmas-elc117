--1
isEven :: Int -> Bool
isEven n = mod n 2 == 0

--2
somaquad :: Int -> Int -> Int
somaquad x y = (x * x) + (y * y)

--3
doubleFirst :: [Int] -> Int
doubleFirst x = (head x) ^ 2

--4
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads (x:xs) (y:ys) = x == y

--5
addPrefix :: [String] -> [String]
addPrefix x = map("Mr. "++) x

--6
countSpaces :: String -> Int
countSpaces x = length(filter(== ' ') x)

--7
aplicaEq :: [Float] -> [Float]
aplicaEq x = map(\n -> (3 * (n^2) + 2/n + 1)) x

--8
calcAge :: [Int] -> [Int]
calcAge x = filter(\n -> (2015 - n) > 1970) x

--9
calcSerie :: Double -> [Double] -> Double
calcSerie m list = sum (map(/m) list)

--10
charFound :: Char -> String -> Bool
charFound c str = not(null(filter(==c) str))

--11
htmlListItems :: [String] -> [String]
htmlListItems x = map("<LI>"++) (map(++"</LI>") x)

--12
{-
> takeWhile (< 5) [1,2,3,4,5]
[1,2,3,4]
> takeWhile (/=' ') "Fulana de Tal"
"Fulana"
> takeWhile (isEven) [2,3,4]
[2]

A função takeWhile retorna os elementos de uma lista enquanto a condição
(podendo ser outra função) passada for verdadeira. Semelhante a função filter.
-}

--13
isFemale :: [String] -> [String]
isFemale list = filter(\n -> last n == 'a') list
