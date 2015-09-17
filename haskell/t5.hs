--1
addSuffix :: String -> [String] -> [String]
addSuffix suffix str = [x ++ suffix | x <- str]

--2
addSuffix' :: String -> [String] -> [String]
addSuffix' _ [] = []
addSuffix' suffix (x:xs) = (x ++ suffix) : addSuffix suffix xs 

--3
countShorts :: [String] -> Int
countShorts [] = 0
countShorts (x:xs)
	| length x < 5 = 1 + countShorts xs
	| otherwise = countShorts xs

--4
countShorts' :: [String] -> Int
countShorts' str = length [x | x <- str, length x < 5]

--5
ciclo :: Int -> [Int] -> [Int]
ciclo 0 _ = []
ciclo n list = list ++ ciclo (n - 1) list

--6
combine :: [Int] -> [String] -> [(Int, String)]
combine [] _ = []
combine _ [] = []
combine (x:xs) (y:ys) = (x, y) : combine xs ys

--7
numera :: [String] -> [(Int, String)]
numera list = numera' 1 list

numera' :: Int -> [String] -> [(Int, String)]
numera' _ [] = []
numera' n (x:xs) = (n, x) : numera' (n + 1) xs

--8
{-
a) [(x, y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y]
Forma uma lista de tuplas onde o x deve ser par [1..5] e o y vai de
(x + 1) até 6 e deve ser ímpar

b) [a ++ b | a <- ["lazy", "big"], b <- ["frog", "dog"]]
Forma uma lista com todas as combinações possíveis entre 
a lista a e a lista b;

c) concat [[a, '-'] | a <- "paralelepipedo", a `elem` "aeiou"]
Concatena todas as vogais de "paralelepipedo" e as separa por "-"
-}

--9
crossProduct :: [a] -> [b] -> [(a, b)]
crossProduct [] _ = []
crossProduct (x:xs) y = pairWithAll x y ++ crossProduct xs y 

pairWithAll :: a -> [b] -> [(a, b)]
pairWithAll _ [] = []
pairWithAll a (b:bs) = (a, b) : pairWithAll a bs

--10
genRects :: Int -> (Int, Int) -> [(Float, Float, Float, Float)]
genRects n (x, y) = genRects' 0 n ((realToFrac x), (realToFrac y))

genRects' :: Int -> Int -> (Float, Float) -> [(Float, Float, Float, Float)]
genRects' cont n (x, y)
	| cont == n = []
	| otherwise = (x, y, 5.5, 5.5) : genRects' (cont + 1) n (x + 5.5, y) 

--11
--decompTupla :: [(Int, Int)] -> ([Int], [Int])
--decompTupla [] = ([], [])
--decompTupla (x:xs) = ([fst x] ++ decompTupla xs, [snd x] ++ decompTupla xs) 


{-
11.Escreva uma função recursiva que receba uma lista de tuplas e
decomponha cada uma delas, gerando uma tupla de listas, conforme o
exemplo abaixo:
> func [(1,3),(2,4)]
([1,2], [3,4])
12.Refaça o exercício anterior usando list comprehension.
13.Refaça o exercício anterior usando uma função de alta ordem.
-}
