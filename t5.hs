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
numera list = numeraAux 1 list

numeraAux :: Int -> [String] -> [(Int, String)]
numeraAux _ [] = []
numeraAux n (x:xs) = (n, x) : numeraAux (n + 1) xs

--8
{-
a) [(x, y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y]
b) [a ++ b | a <- ["lazy", "big"], b <- ["frog", "dog"]]
c) concat [[a, '-'] | a <- "paralelepipedo", a `elem` "aeiou"]
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

--11
decompTupla :: [(a, b)] -> ([a], [b]) 