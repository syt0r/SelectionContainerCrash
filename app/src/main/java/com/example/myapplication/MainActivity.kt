package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                LazyColumn(Modifier.fillMaxSize()) {

                    items((0..100).toList()) {

                        SelectionContainer {
                            val inlineId = it.toString()
                            BasicText(
                                text = buildAnnotatedString {
                                    append("Test Message number")
                                    appendInlineContent(inlineId, inlineId)
                                },
                                inlineContent = mapOf(
                                    inlineId to InlineTextContent(
                                        placeholder = Placeholder(
                                            width = 50.sp,
                                            height = 50.sp,
                                            placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                                        ),
                                        children = { Text(text = it) }
                                    )
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                    }

                }

            }
        }
    }
}