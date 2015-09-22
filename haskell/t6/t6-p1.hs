import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)

-- Gera retangulo SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeRect :: (String,Rect) -> String 
writeRect (style,((x,y),w,h)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera codigo-fonte de arquivo SVG 
-- concatenando uma lista de retangulos e seus atributos de estilo
writeRects :: Float -> Float -> [(String,Rect)] -> String 
writeRects w h rs = 
  printf "<svg width='%.2f' height='%.2f' style='background:gray' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeRect rs) ++ "</svg>"

main :: IO ()
main = do
  let
    lineNumber = 10
    columnNumber = 10
    rectWidth = 50
    rectHeight = 25
    hue = "10"
    
    --Listas com os valores de sat e light
    sat = [100.0, 100.0 - (100.0 / (columnNumber - 1))..0]
    light = [100.0, 100.0 - (100.0 / (lineNumber - 1))..0]

    --Forma uma lista de tuplas com os valores de sat e light
    satLight = [(s, l) | s <- sat, l <- light]

    --Forma uma lista de strings com os valores de hue, sat, light
    colors = map(\sl -> "fill:hsl(" ++ hue ++ ", " ++ show(fst sl) ++ "%, " ++ show(snd sl) ++ "%)") satLight
    
    --Forma listas com valores de x e y
    xs = if(columnNumber == 1) then [10] else if (columnNumber == 2) then [10,rectWidth + 15] else [10,rectWidth + 15..(columnNumber - 1) * (rectWidth + 5)]
    ys = if(lineNumber == 1) then [10] else if (lineNumber == 2) then [10,rectHeight + 15] else [10,rectHeight + 15..(lineNumber - 1) * (rectHeight + 5)]
    
    --Concatena as strings de estilos com as coordenadas x, y
    hsl = zip colors [(((x,y),rectWidth,rectHeight)) | x <- xs, y <- ys]

    --Define o tamanho do <svg>
    (w,h) = (head xs + last xs + rectWidth, head ys + last ys + rectHeight)

  writeFile "colors.svg" $ writeRects (realToFrac w) (realToFrac h) hsl 