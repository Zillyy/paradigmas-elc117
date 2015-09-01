--1
elevaQuad :: [Int] -> [Int]
elevaQuad [] = []
elevaQuad (x:xs) = x ^ 2 : elevaQuad xs

--2
containChar :: Char -> String -> Bool
containChar _ [] = False
containChar c (x:xs)
	| x == c = True
	| x /= c = containChar c xs

--3
semVogais :: String -> String
semVogais [] = []
semVogais (x:xs)
	| (x == 'a') || (x == 'e') || (x == 'i') || (x == 'o') || (x == 'u') = semVogais xs
	| otherwise = x : semVogais xs

--4
translate :: [(Float, Float)] -> [(Float, Float)]
translate [] = []
translate ((x, y) : z) = (x + 2, y + 2) : translate z

--5
geraTabela :: Int -> [(Int, Int)]
geraTabela x = aux 1 x

aux :: Int -> Int -> [(Int, Int)]
aux count x
	| count < x + 1 = (count, count ^ 2) : aux (count + 1) x
	| otherwise = []