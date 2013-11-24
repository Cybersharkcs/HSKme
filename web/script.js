/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function refreshElements(nom)
{
    //definit les elements
    var element = ["pinyin","francais","caractere"];
    //efface tous les elements
    document.getElementById("to").options.length = 0;
    //ajoute ceux necessaires
    for(var i=0;i<3;i++)
    {
        if(element[i].length!==nom.length)
        {
            document.getElementById("to").add(new Option(element[i], element[i])); 
        }
    }
}