<h1>TP1 Hadoop - Map Reduce</h1>
===========

GILANI Tarik &amp; MICHEL Rémi

<h2>Few tips</h2>
To start the first questions (1 to 6), type the following command:
<pre>
<code>
$ hadoop jar tp1-1.jar quest7.WordCount AOL-small.txt WCoutAOL01
</code>
</pre>

AOL-small.txt correspond with the input file. WCoutAOL01 correspond with the output folder.

To start the 7th question, you have to set a temporary folder as 3rd argument (WCoutAOL_02 in this case)
<pre>
<code>
$ hadoop jar tp1-1.jar quest7.WordCount AOL-small.txt WCoutAOL02 WCoutAOL_02
</code>
</pre>

AOL-small.txt correspond with the input file. WCoutAOL02 correspond with the output folder. WCoutAOL_02 correspond with the temporary folder used by the first job to store the result of the first reducer.
